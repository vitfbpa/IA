import os

from Cromossomo import Cromossomo

tamanho_populacao = int(input('Tamanho da população: '))
quantidade_geracoes = int(input('Gerações: '))
taxa_selecao = int(input('Taxa de seleção [25 a 75]: '))
taxa_reproducao = 100 - taxa_selecao
frequencia_mutacao = int(input('Frequencia de mutação: '))

populacao = list()
nova_populacao = list()

Cromossomo.gerar_populacao(populacao, tamanho_populacao)
populacao.sort(key=lambda cromossomo: cromossomo.aptidao)
Cromossomo.exibir_populacao(populacao, 0)

for i in range(1, quantidade_geracoes):
    Cromossomo.selecionar(populacao, nova_populacao, taxa_selecao)
    Cromossomo.reproduzir(populacao, nova_populacao, taxa_reproducao)

    if i % frequencia_mutacao == 0:
        Cromossomo.mutar(nova_populacao)
 
    populacao.clear()
    populacao.extend(nova_populacao)
    nova_populacao.clear()
    populacao.sort(key=lambda cromossomo: cromossomo.aptidao)
    Cromossomo.exibir_populacao(populacao, i)

    if populacao[0].aptidao == 0:
        print(f'\nSolução encontrada na geração {i}: {populacao[0].rota}')
    
    if populacao[0].rota == [1,2,3,4,5,6,7,8,9]:
        print('Rota ideal encontrada: 1,2,3,4,5,6,7,8,9')
    break
