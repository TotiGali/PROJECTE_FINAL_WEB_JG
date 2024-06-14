/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comoba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/images")

public class ImagenController {

    @Autowired
    private ImagenRepository imagenRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        Imagen imagen = new Imagen();
        imagen.setNombre(imageFile.getOriginalFilename());
        imagen.setImagen(imageFile.getBytes());

        imagen = imagenRepository.save(imagen);

        return ResponseEntity.ok(imagen.getId().toString());
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Optional<Imagen> imagenOptional = imagenRepository.findById(id);

        if (imagenOptional.isPresent()) {
            Imagen imagen = imagenOptional.get();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imagen.getNombre() + "\"")
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(imagen.getImagen());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
   
    public ResponseEntity<List<String>> getAllImages() {
        List<Imagen> imagenes = imagenRepository.findAll();
        List<String> imageIds = imagenes.stream()
                                        .map(imagen -> imagen.getId().toString())
                                        .collect(Collectors.toList());
        return new ResponseEntity<>(imageIds, HttpStatus.OK);
    }
    
}
