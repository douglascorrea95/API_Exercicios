package org.serratec.backend.borracharia.repository;

import java.util.List;

import org.serratec.backend.borracharia.DTO.RelatorioDTO;
import org.serratec.backend.borracharia.model.TabelaServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TabelaServicoRepository extends JpaRepository<TabelaServico, Integer>{

	@Query(value="\r\n"
			+ "select\r\n"
			+ "c2.CLIENTE_TX_NOME  as cliente,\r\n"
			+ "c.CARRO_TX_MODELO as modelo,\r\n"
			+ "t.TABELA_TX_SERVICO as tabela,\r\n"
			+ "t.TABELA_NUM_VALOR as valor\r\n"
			+ "from tabela t join carro c on(t.CARRO_ID =c.CARRO_CD_ID_CARRO)\r\n"
			+ "join cliente c2 on(c2.cliente_cd_id=c.CLIENTE_ID)\r\n"
			+ "order by t.TABELA_CD_ID\r\n"
			+ "desc\r\n"
			+ "limit 5", nativeQuery=true)
	
	List<RelatorioDTO> relatorio();

}
