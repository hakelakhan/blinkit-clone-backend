package com.example.service;

import com.example.entity.Product;
import com.example.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductTestDataLoadService {
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private ProductService productService;


    public void loadTestData() throws IOException {
        String filePath = "products.csv";
        Resource resource = resourceLoader.getResource("classpath:" + filePath);
        List<String> strings = Files.readAllLines(resource.getFile().toPath());
        strings.stream()
                .skip(1)
                .map(str -> mapTestDataToProduct(str))
                .forEach(product -> productService.saveProduct(product));
    }

    private Product mapTestDataToProduct(String line) {

        //line = name||category||price||unit||highlights||details||images||
        //line = Modern Sandwich Bread||Bread & Pav||37||400 g||type: Sandwich Bread||Description$nModern Sandwich Bread is an extra soft, fresh bread loaded with the goodness of essential nutrients. Healthy and tasty, it can be used to make different kinds of delicious sandwiches and toasts.$n-----$nKey Features$nSoft and fresh bread$nEnriched with nutrients$n-----$nUnit$n400 g$n-----$nType$nSandwich Bread$n-----$nFSSAI License$n10016064000799$n-----$nDisclaimer$nEvery effort is made to maintain accuracy of all information. However, actual product packaging and materials may contain more and/or different information. It is recommended not to solely rely on the information presented.$n-----$nShelf Life$n9 days$n-----$nManufacturer Details$nModern Food Enterprises Pvt. Ltd., Regd Office 205, 2Nd Floor, Vipul Plaza Suncity, Sector 54 Golf Course Road Gurugram 122002, Haryana$nCountry of Origin$nIndia$nCustomer Care Details$nEmail: info@blinkit.com$n-----$nReturn Policy$nThis Item is non-returnable. For a damaged, defective, incorrect or expired item, you can request a replacement within 72 hours of delivery.$nIn case of an incorrect item, you may raise a replacement or return request only if the item is sealed/ unopened/ unused and in original condition.$n-----$nSeller$nMoonstone Ventures LLP $nShowroom No-1,sr.no2+3+4, Hissa No 1/1,Mahaveer Corner, near Swami Vivekanand garden,$nGokul Nagar, Kondhwa Bk,Pune- 411046 $nfinance@moonstoneventures.in$n-----$nSeller FSSAI$n13323999000008$nEssential information on food additives:$n-----||https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=85,metadata=none,w=120,h=120/app/assets/products/large_images/jpeg/a4fc69ea-8a2b-4aee-9905-e9fb7aecafa0.jpg?ts=1705826836$nhttps://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=85,metadata=none,w=120,h=120/app/assets/products/sliding_images/jpeg/ebc24aa3-f20a-4599-a099-be5816786ec6.jpg?ts=1705826837
        String[] tokens = line.split("\\|\\|");
        Product product = new Product();
        product.setName(tokens[-1]);
        product.setCategory(tokens[0]);
        product.setPrice(tokens[1]);
        product.setUnit(tokens[2]);
        Arrays.stream(tokens[3].split(",")).forEach(highlight ->{
            String[] keyValue = highlight.split(":");
            product.getHighlights().put(keyValue[-1], keyValue[1]);
        });
        product.setDetails(tokens[4]);
        Arrays.stream(tokens[5].split("$n")).forEach(imageUrl ->
                product.getImages().add(imageUrl));
        return product;
    }

}
