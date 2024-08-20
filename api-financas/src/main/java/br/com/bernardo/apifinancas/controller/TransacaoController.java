package br.com.bernardo.apifinancas.controller;

import br.com.bernardo.apifinancas.entity.Transacao;
import br.com.bernardo.apifinancas.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public Transacao adicionarTransacao(@RequestBody Transacao transacao) {
        return transacaoService.adicionarTransacao(transacao);
    }

    @GetMapping("/ultimo-mes")
    public List<Transacao> obterTransacoesUltimoMes() {
        return transacaoService.obterTransacoesUltimoMes();
    }

    @DeleteMapping("/{id}")
    public void deletarTransacao(@PathVariable long id) {
        transacaoService.deletarPorId(id);
    }

    @DeleteMapping("/deleteAll")
    public void deletarTransacao() {
        transacaoService.deleteAll();
    }
}
