package visoes;

import documin.documento.Documento;

/**
 * 
 * @author Geraldo Sobreira Júnior
 *
 */

public abstract class visao {
	protected Documento documento;
	
	public visao(Documento documento) {
		this.documento = documento;
	}
	
	public abstract String[] exibeVisao();
}
