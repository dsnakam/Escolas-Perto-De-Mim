const form = document.getElementById('formBusca');

form.addEventListener('submit', function(event) {
    event.preventDefault();

    const endereco = document.getElementById('q').value;
    const lista = document.getElementById('resultados');

    fetch(`/escolas-proximas?q=${encodeURIComponent(endereco)}`)
        .then(function(response) {
            if (!response.ok) {
                throw new Error('Endereço não encontrado');
            }
            return response.json();
        })
        .then(function(escolasDistancia) {
            lista.innerHTML = '';

            escolasDistancia.forEach(function(item) {
                const li = document.createElement('li');
                li.textContent = item.escola.nomeEscola + ' - ' + item.distancia.toFixed(2) + ' km';
                lista.appendChild(li);
            });
        })
        .catch(function(erro) {
            lista.innerHTML = '';
            const li = document.createElement('li');
            li.textContent = erro.message;
            lista.appendChild(li);
        });
});