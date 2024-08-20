package br.com.bernardo.apifinancas.repository;

import br.com.bernardo.apifinancas.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findAllByDataBetween(LocalDate startDate, LocalDate endDate);
}
