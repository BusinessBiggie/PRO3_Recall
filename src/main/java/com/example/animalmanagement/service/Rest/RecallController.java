package com.example.animalmanagement.service.Rest;

import com.example.ProductOuterClass;
import com.example.animalmanagement.service.grpc.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/recall")
public class RecallController {

  @Autowired
  private ProductService service;


  @GetMapping("/products-from-pig/{pigId}")
  public List<Long> getAllProductIdsFromPigId(@PathVariable Long pigId) {
    List<Long> ids = new ArrayList<>();
    ProductOuterClass.ProductListResponse response = service.getProductsByPigId(pigId);
    response.getProductIdList().forEach(id->ids.add(id));
    return ids;
  }

  @GetMapping("/pigs-from-product/{productId}")
  public List<Long> getPigIdsFromProduct(@PathVariable Long productId) {
    List<Long> ids = new ArrayList<>();

    ProductOuterClass.PigsResponse response = service.getAllPigsFromProductId(productId);
    response.getPigsList().forEach(pig->ids.add(pig.getId()));
    return ids;
  }
}
