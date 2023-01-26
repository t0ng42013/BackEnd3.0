package com.portfolio.LGA.service;

import com.portfolio.LGA.InterService.IBannerService;
import com.portfolio.LGA.model.Banner;
import com.portfolio.LGA.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService implements IBannerService {

    @Autowired
    public BannerRepository bannerRepository;
    @Override
    public List<Banner> verBanner() {return bannerRepository.findAll(); }

    @Override
    public void crearBanner(Banner banner) {  bannerRepository.save(banner);    }


    @Override
    public void borrarBanner(Long id) {
        bannerRepository.deleteById(id);
    }

    @Override
    public Banner buscarBanner(Long id) {
        return bannerRepository.findById(id).orElse(null);
    }

    @Override
    public Banner editarBanner(Banner banner) {
        Banner banners= bannerRepository.findById(banner.getId()).orElse(null);
        banner.setNombreUrl(banner.getNombreUrl());

        return bannerRepository.save(banners);
    }
}
