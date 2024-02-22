package gr.codehub.firsteuropeandynapp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class ImageController {

    @GetMapping("image")
    public ResponseEntity<byte[]> getImage() throws IOException {
        byte[] data = Files.readAllBytes(Paths.get("images\\springboot.png"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(data.length);
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(data, headers, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("image2")
    public ResponseEntity<byte[]> getImage2() throws IOException {
        BufferedImage image = ImageIO.read(new File("images\\springboot.png"));
        Graphics2D g2d = (Graphics2D)image.getGraphics();

        g2d.setColor(Color.RED);
        g2d.fillOval(40,40,70,70);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        g2d.setColor(Color.YELLOW);
        g2d.drawString("European Dynamics", 20, 100);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(baos.toByteArray().length);
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.NOT_FOUND);
        return responseEntity;
    }



}
