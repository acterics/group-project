package com.groupproject.image.service;

import com.groupproject.image.configuration.ImgproxyConfiguration;
import com.groupproject.image.model.Image;
import com.groupproject.image.model.ProxiedImage;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ImageService {

    private final byte[] imgproxyKey;
    private final byte[] imgproxySalt;

    private final Base64.Encoder base64encoder;

    @Autowired
    public ImageService(ImgproxyConfiguration imgproxyConfiguration) {
        imgproxyKey = Hex.decode(imgproxyConfiguration.getKey());
        imgproxySalt = Hex.decode(imgproxyConfiguration.getSalt());

        base64encoder = Base64.getEncoder();
    }

    public List<ProxiedImage> getItems(List<Image> images) {

        ArrayList<ProxiedImage> proxiedImages = new ArrayList<>();

        for(Image image: images) {
            proxiedImages.add(new ProxiedImage(getSignedUrl(image)));
        }

        return proxiedImages;
    }

    public String encode(byte [] text) {
        String encoded = new String(base64encoder.encode(text));

        return encoded.replaceAll("=", "").replaceAll("\\+", "-").replaceAll("/", "_");
    }

    public String sign(String unsignedUrl) throws InvalidKeyException, NoSuchAlgorithmException {
        byte[] target = unsignedUrl.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[imgproxySalt.length + target.length];

        System.arraycopy(imgproxySalt, 0, data, 0, imgproxySalt.length);
        System.arraycopy(target, 0, data, imgproxySalt.length, target.length);

        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = new SecretKeySpec(imgproxyKey, "HmacSHA256");
        sha256_HMAC.init(secretKey);

        final byte[] hash = sha256_HMAC.doFinal(data);

        return encode(hash);
    }

    public String getSignedUrl(Image image) {
        String unsignedUrl = getUrl(image);

        String signature;

        try {
            signature = sign(unsignedUrl);
        } catch (Exception e) {
            e.printStackTrace();

            return "";
        }

        return "/" + signature + unsignedUrl;
    }

    public String getUrl(Image image) {
        String encodedUrl = encode(image.getUrl().getBytes(StandardCharsets.UTF_8));

        return
            "/" + image.getResizingType() +
            "/" + image.getWidth() +
            "/" + image.getHeight() +
            "/" + image.getGravity() +
            "/" + image.getEnlarge() +
            "/" + encodedUrl +
            "." + image.getExtension();

    }
}
