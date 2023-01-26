package com.portfolio.LGA.controller;

import com.portfolio.LGA.InterService.IBannerService;
import com.portfolio.LGA.dto.Mensaje;
import com.portfolio.LGA.model.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banner")
@CrossOrigin(origins = {"https://lga-portfolio.web.app","http://localhost:4200"})
public class BannerController {
    @Autowired
    private IBannerService bannerService;

    @GetMapping("/lista")
    public ResponseEntity<List<Banner>> verBanner() {
        List<Banner> banners = bannerService.verBanner();
        return new ResponseEntity(banners, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public void agregarBanner(@RequestBody Banner banner){
        bannerService.crearBanner(banner);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarBanner(@RequestBody Banner banner) {
        bannerService.editarBanner(banner);
        return new ResponseEntity(new Mensaje("Banner editado"), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Banner> buscarBanner(@PathVariable Long id) {
        if (bannerService.buscarBanner(id) == null) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(bannerService.buscarBanner(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarBanner(@PathVariable Long id){
        bannerService.borrarBanner(id);
    }
}
