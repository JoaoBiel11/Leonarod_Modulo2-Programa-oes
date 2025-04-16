const API = 'http://localhost:8080';

function adicionarCliente() {
  const cliente = {
    nome: document.getElementById('nome').value,
    sobrenome: document.getElementById('sobrenome').value,
    cpf: document.getElementById('cpf').value
  };

  fetch(`${API}/cliente`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(cliente)
  })
  .then(res => res.json())
  .then(data => alert('Cliente adicionado com sucesso!'))
  .catch(err => console.error(err));
}

function adicionarLivro() {
  const livro = {
    nome: document.getElementById('nomeLivro').value,
    autor: document.getElementById('autorLivro').value,
    genero: document.getElementById('generoLivro').value,
    isbn: document.getElementById('isbnLivro').value
  };

  fetch(`${API}/livro`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(livro)
  })
  .then(res => res.json())
  .then(data => alert('Livro adicionado com sucesso!'))
  .catch(err => console.error(err));
}

function adicionarEmprestimo() {
  const clienteId = parseInt(document.getElementById('idCliente').value);
  const livrosIds = document.getElementById('livrosIds').value.split(',').map(id => ({ id: parseInt(id.trim()) }));

  const emprestimo = {
    dataInicial: document.getElementById('dataInicial').value,
    dataFinal: document.getElementById('dataFinal').value,
    cliente: { id: clienteId },
    livros: livrosIds
  };

  fetch(`${API}/emprestimo`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(emprestimo)
  })
  .then(res => res.json())
  .then(data => alert('Empréstimo cadastrado com sucesso!'))
  .catch(err => console.error(err));
}
