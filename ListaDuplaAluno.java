package trabalhoED;

		public class ListaDuplaAluno {
			private NoDuplaAluno prim;
			private NoDuplaAluno ult;
			private int quantNos;
		
		public ListaDuplaAluno(){
			this.prim = null;
			this.ult = null;
			this.quantNos = 0;
			}
		
		public int getQuantNos(){
			return this.quantNos;
			}
		
		public NoDuplaAluno getPrim(){
			return this.prim;
			}
		
		public NoDuplaAluno getUlt(){
			return this.ult;
			}
		
		public void setQuantNos(int valorNovo){
			this.quantNos = valorNovo;
			}
		
		public void setPrim(NoDuplaAluno novoNo){
			this.prim = novoNo;
			}
		
		public void setUlt(NoDuplaAluno novoNo){
			this.ult = novoNo;
			}
		
		public boolean eVazia (){
			return (this.prim == null);
			}
		
		public void inserirAluno (Aluno elem){
			NoDuplaAluno novoNo = new NoDuplaAluno (elem);
			this.quantNos++;
			if (this.eVazia())
				this.prim = novoNo;
			else {
				novoNo.setAnt(this.ult);
				this.ult.setProx(novoNo);
			}
			this.ult = novoNo;
			}
		
		public void localizarAluno (String x){
			NoDuplaAluno atual = this.prim;
			while (atual != null) {
				if (atual.getInfo().getNome().equalsIgnoreCase(x)) {
					System.out.println("Matricula: "+ atual.getInfo().getMatricula() 
					+ "\nNome: "+ atual.getInfo().getNome()
					+ "\nEndereço: "+ atual.getInfo().getEndereco()
					+ "\nTelefone: "+ atual.getInfo().getTelefone());
				atual = atual.getProx();
			}else {
				atual = atual.getProx();
				if (atual == null) {
					System.out.println("Aluno não encontrado. Verique o se o nome foi digitado corretamente ou se ele se encontra na lista.");
				}
			}
			}
			}

		public boolean removerAluno (long x){
		NoDuplaAluno atual = this.prim;
		while ((atual != null) && (atual.getInfo().getMatricula() != x)){
			atual = atual.getProx();
		}
		if (atual == null) {
			return false;
		}else {
			if (atual == this.prim){
				this.prim = prim.getProx();
				if (this.prim == null) { 
					this.ult=null;
				}else {
					this.prim.setAnt(null);
				}
			}else {
				if (atual == this.ult){ 
					this.ult = this.ult.getAnt();
					this.ult.setProx(null);
			} else {
				atual.getProx().setAnt(atual.getAnt());
				atual.getAnt().setProx(atual.getProx());
			}
			}
			this.quantNos--;
			return true;
			}
			}
		
		public Aluno localizarMatricula(long matricula) {
		    NoDuplaAluno atual = this.prim;
		    while (atual != null) {
		        if (atual.getInfo() != null && atual.getInfo().getMatricula() == matricula) {
		            return atual.getInfo();
		        }
		        atual = atual.getProx();
		    }
		    return null; 
		}

		public boolean transferirAluno(long matricula, ListaDuplaAluno alunos) {
		    Aluno aluno = alunos.localizarMatricula(matricula);
		    alunos.removerAluno(matricula);
		    NoDuplaAluno novo = new NoDuplaAluno(aluno);
		    if (this.prim == null) {
		        this.prim = this.ult = novo;
		        this.quantNos++;
		        return true;
		    }
		    if (aluno.getMatricula() < this.prim.getInfo().getMatricula()) {
		        novo.setProx(this.prim);
		        this.prim.setAnt(novo);
		        this.prim = novo;
		    }else {
		        NoDuplaAluno atual = this.prim;
		        while (atual.getProx() != null && 
		               atual.getProx().getInfo() != null &&
		               atual.getProx().getInfo().getMatricula() < aluno.getMatricula()) {
		            atual = atual.getProx();
		        }
		        novo.setProx(atual.getProx());
		        novo.setAnt(atual);
		        if (atual.getProx() != null) {
		            atual.getProx().setAnt(novo);
		        }else {
		            this.ult = novo;
		        }
		        atual.setProx(novo);
		    }
		    this.quantNos++;
		    return true;
		}
		
		public void imprimirLista() {
			NoDuplaAluno atual = this.prim;
			while (atual != null) {
				Aluno a = atual.getInfo();
			System.out.println("Matricula: "+ a.getMatricula() 
					+ "\nNome: "+ a.getNome()
					+ "\nEndereço: "+ a.getEndereco()
					+ "\nTelefone: "+ a.getTelefone());
			atual = atual.getProx();
			}
			}
	}