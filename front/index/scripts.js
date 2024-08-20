document
  .getElementById("transactionForm")
  .addEventListener("submit", function (event) {
    event.preventDefault();

    const formData = new FormData(this);
    const tipoSelect = document.getElementById("tipo");
    const tipoValue = tipoSelect.value;

    if (tipoValue === "default") {
      alert("Por favor, selecione um tipo válido.");
      event.preventDefault();
      return;
    }

    const data = {
      tipo: formData.get("tipo"),
      descricao: formData.get("descricao"),
      valor: parseFloat(formData.get("valor")),
      categoria: formData.get("categoria"),
    };

    fetch("http://localhost:8080/api/transacoes", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    })
      .then((response) => response.json())
      .then((result) => {
        alert("Transação adicionada com sucesso!");
        console.log(result);
        window.location.href =
          "http://127.0.0.1:5500/ultimo_mes/ultimo_mes.html";
      })
      .catch((error) => {
        alert("Erro ao adicionar transação.");
        console.error(error);
      });
  });
