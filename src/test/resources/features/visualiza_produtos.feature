#language: pt
Funcionalidade: Visualizar produtos
  Como um usuario nao logado
  Eu quero visualizar produtos disponiveis
  Para poder escolher qual eu irei comprar

  Cenario: Devo mostrar uma lista de oito produtos na pagina inicial
    Dado que estou na pagina incial
    Quando nao estou logado
    Entao visualizo oito produtos disponiveis
    E carrinho esta zerado