package com.groupproject.apigateway.service

import com.groupproject.apigateway.client.ImageClient
import com.groupproject.apigateway.domain.image.Image
import com.groupproject.apigateway.domain.image.ImageLinksRequest
import com.groupproject.apigateway.domain.image.OutputImage
import com.groupproject.apigateway.domain.product.CatalogEntry
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import rx.Observable
import java.net.InetAddress

@Service
class ImageService
@Autowired constructor(private val imageClient: ImageClient) {


    fun getImagesFromProducts(products: List<CatalogEntry>, width: Int, height: Int): Observable<List<OutputImage>> =
        Observable.just(products)
                .map { it.flatMap { product -> product.photos } }
                .map { photos -> photos.map { photo -> Image(photo.filename, width, height) } }
                .map { images -> ImageLinksRequest(images) }
                .flatMap { request -> Observable.just(imageClient.getLinks(request)) }
                .map { response -> response.images }

    fun proxyProductsImages(products: List<CatalogEntry>, images: List<OutputImage>) {
        images.map { image -> "${InetAddress.getLocalHost().hostAddress}/imgproxy${image.url}" }
                .zip(products.flatMap { it.photos }, { url, photo -> photo.filename = url })
    }

}