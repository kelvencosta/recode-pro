Algoritmo "agencia-de-viagens"
// Aluno: Keven Gonçalves da costa
// Descrição: simulação de cadastro para uma agência de viagens.


// Gera um menu de opções interativo
funcao menu():caracter
var
   opcao:inteiro
inicio
   escreval(" ")
   escreval(" ")
   escreval("|                       Escolha o serviço             |")
   escreval("|           (1)cadastrar-se  (2)cadastrar viangem     |")
   escreval("|           (3)ver cadrastro (4)ver destino  (5)sair: |")
   escreva("serviço: ")

   leia(opcao)
   escolha opcao
   //roda o serviço escolhido
   caso 1 
      limpatela()
      posicao <- posicao + 1
      escreva(cadastroCliente())
   caso 2
      limpatela()
      escreva(cadastroDstino())
   caso 3
      limpatela()
      escreval("========================== CADASTROS ==========================")
      para i de 1 ate 50 faca
         se (listNome[i] = "") ou (listCpf[i] = "") entao
            retorne(" ")
         senao
            escreval("|Nome:"+ listNome[i] +"  CPF:"+ listCpf[i] +"|")
         fimse
      fimpara
      escreva(menu())
   caso 4
      limpatela()
      escreval("========================== DESTINOS ==========================")
      para i de 1 ate 50 faca
         se (listNome[i] = "") ou (listDestino[i] = "") entao
            retorne(" ")
         senao
            escreval("|Nome:"+ listNome[i] +"  Destino:"+ listDestino[i] +"|")
         fimse
      fimpara
      escreva(menu())
   caso 5
      limpatela()
      escreva("Obrigado pela preferência e confiança!")
   outrocaso
      escreva(menu())
   fimescolha
fimfuncao

//Cadastra dados do cliente
funcao cadastroCliente():caracter
inicio
   escreva("Digite o seu nome: ")
   leia(nome)
   escreva("Digite o seu CPF: ")
   leia(cpf)

   listNome[posicao] <- nome
   listCpf[posicao] <- cpf

   escreval("CADASTRADO COM SUCESSO")
   escreval(" ")
   escreva(menu())
fimfuncao

//Cadastra viagens
funcao cadastroDstino():caracter
inicio
//verifica se há cadastro
   se posicao <> 0 entao
      escreva("Digite o seu destino: ")
      leia(destino)
      escreva("Marque a data: ")
      leia(data)
      
      listDestino[posicao] <- destino + " " + data
      escreval("Viagem marcada para: "+destino+" "+ data)
   senao
      escreval("!Você não está cadastrado!")
   fimse

   escreval(" ")
   escreva(menu())
fimfuncao

Var
   nome,cpf,destino,data:caracter
   listNome,listCpf,listDestino:vetor [1..50] de caracter
   i:inteiro          //index loop
   posicao:inteiro   //posição na listas

Inicio
   posicao <- 0

   escreval("BEM-VINDO A NOSSA AGÉNCIA DE VIANGENS, O QUE VOCÊ GOSTARIA?")
   escreval("=================================================================")
   escreva(menu())
Fimalgoritmo