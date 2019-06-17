package com.clientui.proxies;


import com.clientui.beans.ProductBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Component //pas dans le cours
//@FeignClient(name = "microservice-produits")// avant la redirection vers l'API gate zull
@FeignClient(name = "zuul-server")
//@FeignClient(name = "microservice-produits", url = "localhost:9001") // avant ribbon
//@RibbonClient(name = "microservice-produits") // remplacement par la configuration LocalRibbonClientConfiguration
public interface MicroserviceProduitsProxy {

    @GetMapping(value = "/Produits")
    List<ProductBean> listeDesProduits();

    @GetMapping( value = "/Produits/{id}")
    ProductBean recupererUnProduit(@PathVariable("id") int id);

}
