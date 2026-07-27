package trabalhoED;
	
	public class NoDuplaAluno {
		private Aluno info; 
		private NoDuplaAluno prox;
		private NoDuplaAluno ant;
		
		public NoDuplaAluno (Aluno elem){
		this.info = elem;
		this.prox = null;
		this.ant = null;
		
		}
		public Aluno getInfo (){
		return this.info;
		}
		public NoDuplaAluno getProx(){
		return this.prox;
		}
		public NoDuplaAluno getAnt(){
		return this.ant;
		}
		public void setProx(NoDuplaAluno novoNo){
		this.prox = novoNo;
		}
		public void setAnt(NoDuplaAluno novoNo){
		this.ant = novoNo;
		}
	
	}
