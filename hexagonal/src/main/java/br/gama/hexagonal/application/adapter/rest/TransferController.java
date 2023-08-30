package br.gama.hexagonal.application.adapter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.gama.hexagonal.application.adapter.rest.dto.Historic;
import br.gama.hexagonal.application.adapter.rest.dto.HistoricRequest;
import br.gama.hexagonal.application.adapter.rest.dto.TransferRequest;
import br.gama.hexagonal.application.port.in.TransferOperation;
import br.gama.hexagonal.domain.model.Transfer;

@Controller
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferOperation service;

    @PostMapping
    public ResponseEntity<Transfer> transfer(@RequestBody TransferRequest request) {
        return ResponseEntity.ok(
            service.tranfer(
                request.getAccountSource(), 
                request.getAccountTarged(), 
                request.getValue()).get() 
            );

    }

    @GetMapping
    public ResponseEntity<List<Historic>> getTranferByDate(@RequestBody HistoricRequest request){
        List<Historic> extrato = service.historic(request.getAccountNumber(), 
            request.getDateFrom(), 
            request.getDateTo());
        return ResponseEntity.ok(extrato);

    }
}
