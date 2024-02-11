#language: pt
Funcionalidade: Busca de produtos

  Cenário: Buscar por um produto
    Dado eu estou na página inicial da Amazon
    Quando eu insiro "O Hobbit" no campo de busca
    E clico no botão de busca
    Então deve ser redirecionado para página de resultados de busca

  Cenário: Buscar por um produto inexistente
    Dado eu estou na página inicial da Amazon
    Quando eu insiro "jkbahblduyasvouyvacouasdafd" no campo de busca
    E clico no botão de busca
    Então deve ser redirecionado para página de resultados com nenhum resultado

