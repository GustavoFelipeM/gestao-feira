package br.ufrpe.gestao_feira.service;

import br.ufrpe.gestao_feira.classesbasicas.*;
import br.ufrpe.gestao_feira.repositorio.VendaRepositorio;
import br.ufrpe.gestao_feira.repositorio.interfaces.*;
import br.ufrpe.gestao_feira.service.dto.*;

import java.util.ArrayList;
import java.util.List;

public class Relatorio
{
    private IVendaRepositorio vendaRepositorio;

    public Relatorio(VendaRepositorio vendaRepositorio)
    {
        this.vendaRepositorio = vendaRepositorio;
    }


    public List<RelatorioVendaPorEdicaoDTO> relatorioVendasPorEdicao()
    {
        List<Venda> vendas = vendaRepositorio.recuperarTudo();
        List<RelatorioVendaPorEdicaoDTO> relatorio = new ArrayList<>();

        for (Venda venda : vendas)
        {
            EdicaoFeira edicaoFeira =  venda.getEdicaoFeira();
            String data = edicaoFeira.getData().toString();
            String local = edicaoFeira.getLocal();

            boolean encontrado = false;
            for (RelatorioVendaPorEdicaoDTO dto : relatorio)
            {
                if(dto.getDataEdicao().equals(data) && dto.getLocal().equals(local))
                {
                    dto.setTotalVendido(dto.getTotalVendido()+venda.calcularVendaTotal());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado)
            {
                relatorio.add(new RelatorioVendaPorEdicaoDTO(data, local, venda.calcularVendaTotal()));
            }
        }
        return relatorio;
    }
    public List<RelatorioVendaPorProdutorDTO> relatorioVendaPorProdutor()
    {
        List<Venda> vendas = vendaRepositorio.recuperarTudo();
        List<RelatorioVendaPorProdutorDTO> relatorio = new ArrayList<>();

        for (Venda venda : vendas)
        {
            Produtor p = venda.getProdutor();
            String nome = p.getNome();
            String categoria = p.getCategoria();

            boolean encontrado = false;
            for (RelatorioVendaPorProdutorDTO dto : relatorio)
            {
                if (dto.getNomeProdutor().equals(nome))
                {
                    dto.setTotalVendido(dto.getTotalVendido() + venda.calcularVendaTotal());
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                relatorio.add(new RelatorioVendaPorProdutorDTO(nome, categoria, venda.calcularVendaTotal()));
            }
        }

        return relatorio;
    }
    public List<RelatorioVendaPorProdutoDTO> relatorioVendaPorProduto()
    {
        List<Venda> vendas = vendaRepositorio.recuperarTudo();
        List<RelatorioVendaPorProdutoDTO> relatorio = new ArrayList<>();

        for (Venda venda : vendas)
        {
            for (ItemVenda item : venda.getItensVenda())
            {
                Produto produto = item.getProduto();
                String nome = produto.getNome();
                String categoria = produto.getCategoria();
                double valor = item.getValorTotal();

                boolean encontrado = false;
                for (RelatorioVendaPorProdutoDTO dto : relatorio)
                {
                    if (dto.getNomeProduto().equals(nome))
                    {
                        dto.setTotalVendido(dto.getTotalVendido() + valor);
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado)
                {
                    relatorio.add(new RelatorioVendaPorProdutoDTO(nome, categoria, valor));
                }
            }
        }

        return relatorio;
    }
}
