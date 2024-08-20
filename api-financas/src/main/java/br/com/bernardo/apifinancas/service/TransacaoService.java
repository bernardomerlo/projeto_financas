package br.com.bernardo.apifinancas.service;

import br.com.bernardo.apifinancas.entity.Transacao;
import br.com.bernardo.apifinancas.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao adicionarTransacao(Transacao transacao) {
        if (transacao.getData() == null) {
            transacao.setData(LocalDate.now());
        }
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> obterTransacoesUltimoMes() {
        LocalDate primeiroDiaDoMesAtual = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDate ultimoDiaDoMesAtual = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        return transacaoRepository.findAllByDataBetween(primeiroDiaDoMesAtual, ultimoDiaDoMesAtual);
    }

    public void deletarPorId(Long id) {
        transacaoRepository.deleteById(id);
    }

    public void deleteAll() {
        transacaoRepository.deleteAll();
    }
}
