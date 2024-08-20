document.addEventListener("DOMContentLoaded", function () {
  fetch("http://localhost:8080/api/transacoes/ultimo-mes")
    .then((response) => response.json())
    .then((transacoes) => {
      const tableBody = document
        .getElementById("transacoesTable")
        .getElementsByTagName("tbody")[0];
      transacoes.forEach((transacao) => {
        const row = tableBody.insertRow();
        row.insertCell(0).textContent = transacao.tipo;
        row.insertCell(1).textContent = transacao.descricao;
        row.insertCell(2).textContent = transacao.valor;
        row.insertCell(3).textContent = transacao.categoria;
        row.insertCell(4).textContent = transacao.data; // Formate a data se necessário
      });
    })
    .catch((error) => {
      console.error("Erro ao carregar transações:", error);
    });
});
