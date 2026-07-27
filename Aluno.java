package trabalhoED;
	
	public class Aluno {
		
		private long matricula;
		private String nome;
		private String endereco;
		private String telefone;
		
		public Aluno() {
			this.matricula = 0;
			this.nome = "";
			this.endereco = "";
			this.telefone = "";
		}
	
		public long getMatricula() {
			return matricula;
		}
	
		public void setMatricula(long matricula) {
			this.matricula = matricula;
		}
	
		public String getNome() {
			return nome;
		}
	
		public void setNome(String nome) {
			this.nome = nome;
		}
	
		public String getEndereco() {
			return endereco;
		}
	
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
	
		public String getTelefone() {
			return telefone;
		}
	
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		
		public void AdicionarAluno(long matricula, String nome, String endereco, String telefone) {
			this.setMatricula(matricula);
			this.setNome(nome);
			this.setEndereco(endereco);
			this.setTelefone(telefone);
		}
	}