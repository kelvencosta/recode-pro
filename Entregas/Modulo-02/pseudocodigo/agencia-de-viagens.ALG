Algoritmo "agencia-de-viagens"
// Aluno: Keven Gon�alves da costa
// Descri��o: simula��o de cadastro para uma ag�ncia de viagens.


// Gera um menu de op��es interativo
funcao menu():caracter
var
   opcao:inteiro
inicio
   escreval(" ")
   escreval(" ")
   escreval("|                       Escolha o servi�o             |")
   escreval("|           (1)cadastrar-se  (2)cadastrar viangem     |")
   escreval("|           (3)ver cadrastro (4)ver destino  (5)sair: |")
   escreva("servi�o: ")

   leia(opcao)
   escolha opcao
   //roda o servi�o escolhido
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
      escreva("Obrigado pela prefer�ncia e confian�a!")
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
//verifica se h� cadastro
   se posicao <> 0 entao
      escreva("Digite o seu destino: ")
      leia(destino)
      escreva("Marque a data: ")
      leia(data)
      
      listDestino[posicao] <- destino + " " + data
      escreval("Viagem marcada para: "+destino+" "+ data)
   senao
      escreval("!Voc� n�o est� cadastrado!")
   fimse

   escreval(" ")
   escreva(menu())
fimfuncao

Var
   nome,cpf,destino,data:caracter
   listNome,listCpf,listDestino:vetor [1..50] de caracter
   i:inteiro          //index loop
   posicao:inteiro   //posi��o na listas

Inicio
   posicao <- 0

   escreval("BEM-VINDO A NOSSA AG�NCIA DE VIANGENS, O QUE VOC� GOSTARIA?")
   escreval("=================================================================")
   escreva(menu())
Fimalgoritmo