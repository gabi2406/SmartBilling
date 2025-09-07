package org.smartbilling.controller;

import org.smartbilling.model.Invoice;
import org.smartbilling.service.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
 /* @RestController marks the class as a REST controller,
 combining @Controller and @ResponseBody. Spring will
 handle HTTP requests and return responses in JSON format.
 */

@RequestMapping("/invoices")
 /* @RequestMapping specifies the base URL path for all
 endpoints in this controller. All methods will start
 with '/invoices'.
 */

public class InvoiceController extends GenericController <Invoice, Long>{
    private final InvoiceService service;
    public InvoiceController(InvoiceService service){
        super(service);
        this.service = service;
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return super.getAll();
    }


    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable Long id) {
        return super.getById(id);
    }
}
