/**
 * 1. Variáveis de Controle:
 *  - O código começa selecionando diversos elementos HTML usando a função "document.querySelector" e "document.querySelectorAll". Esses elementos são necessários para interagir com a interface da calculadora.
 *    Os elementos selecionados são armazenados em variáveis para uso posterior.
 */
const campoResult = document.querySelector('.js-resultado');
let input = '';
let resultExibido = false;

/**
 * 2. Função "adicionaElementoAoInputResultado":
 *    - Esta função é responsável por adicionar um número ou operador ao campo de entrada da calculadora.
 *      Lembre-se de verificar se o símbolo/operador já está presente no resultado.
 *      Verifique também se o símbolo/operador é o primeiro a ser inserido e evite a adição se for o caso.
 */
function adicionaElementoAoInputResultado(elemento) {
  const operadores = ['+', '-', '*', '/'];

  if (operadores.includes(elemento)) {
    if (input.length > 0 && elemento != input[input.length-1]) {
      input = input.concat(elemento);
    }
  }
  else {
    if (resultExibido) {
      input = elemento;
    }
    else {
      input = input.concat(elemento);
    }
  }

  campoResult.value = input;
  resultExibido = false;
}

/**
 * 3. Função "executarCalculo:
 *  - Esta função é responsável por calcular o resultado da expressão matemática presente no campo de entrada.
 *    Ela usa a função "eval()" para avaliar a expressão e, em seguida, atualiza o campo de entrada com o resultado. Se ocorrer algum erro durante a avaliação, ela exibe um alerta.
 *  - Syntax função eval()
 *    - eval(string)
 *      - string: Uma expressão, variável, instrução ou sequência de instruções JavaScript
 */
function executarCalculo() {
  try {
    input = String(eval(input) ?? '');
    campoResult.value = input;
  }
  catch {
    input = ''
    campoResult.value = 'Erro';
  }
  resultExibido = true;
}

/**
 *  4 . Função "limparResultado":
 *  - Essa função limpa o campo de entrada, ou seja, remove todos os números e operadores presentes nele.
 */
function limparResultado() {
  campoResult.value = input = '';
}

/**
 * 5. Função "trocarSinalDaConta":
 *  - Essa função inverte o sinal do número no campo de entrada. Ela verifica se o valor atual é um número (positivo ou negativo) e, se for, inverte o sinal.
 */
function trocarSinalDaConta() {

  if (input.length == 0) {
    input = '-';
  }
  else {
    let inputRev = input.split('').reverse();
    let ind = inputRev.findIndex(x => /\D/.test(x));

    if (ind == -1) {
      inputRev.splice(inputRev.length, 0, '-');
    }
    else {
      if (inputRev[ind] == '-') {
        inputRev.splice(ind, 1, '+');
      }
      else if (inputRev[ind] == '+') {
        inputRev.splice(ind, 1, '-');
      }
      else {
        inputRev.splice(ind, 0, '-');
      }
    }
    input = inputRev.reverse().join('');
  }
  campoResult.value = input;
}

/**
 * 6. Função "deletarUltimaLetraDoResultado":
 *  - Esta função remove o último caractere do campo de entrada. É usada quando o usuário pressiona o botão de deletar.
 */
function deletarUltimaLetraDoResultado() {
  if (input.length > 0) {
    input = input.slice(0, -1);
    campoResult.value = input;
  }
}

/**
 * 7. Função "gerenciarEscutadores":
 *  - Esta função atribui ouvintes de eventos (event listeners) a vários elementos HTML, como números, operadores e botões de ação.
 *     Quando o usuário clica em um desses elementos, a função correspondente é chamada para manipular a entrada do usuário.
 *  - Os listeners para numeros e (alguns) operadores já estão prontos, mas você precisa implementar a função "adicionaElementoAoInputResultado".
 */
function gerenciarEscutadores() {
  document
    .querySelector(".js-btn-igual")
    .addEventListener("click", () => executarCalculo());

  document
    .querySelector(".js-btn-del")
    .addEventListener("click", () => deletarUltimaLetraDoResultado());

  document
    .querySelector(".js-btn-ac")
    .addEventListener("click", () => limparResultado());

  document
    .querySelector(".js-btn-mais-menos")
    .addEventListener("click", () => trocarSinalDaConta());

  document.querySelectorAll(".js-btn-padroes").forEach((element) => {
    element.addEventListener("click", function (event) {
      adicionaElementoAoInputResultado(
        event.target.attributes["data-valor"].value
      );
    });
  });
}

/**
 * 8. Chamada de "gerenciarEscutadores":
 *   - No final do código, a função "gerenciarEscutadores" é chamada, configurando os ouvintes de eventos para que a calculadora
 *     responda aos cliques dos usuários.
 */
gerenciarEscutadores();
