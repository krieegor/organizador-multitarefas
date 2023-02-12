package br.com.organizador.tarefas.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

@Table(name = "TB_PESSOAS")
public class TbUsuarios {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_pessoa;

    @Column(name = "NOME", nullable=false, length=5000)
    @NotBlank(message = "O campo nome não pode estar em branco")
    private String nome;

    @Column(name = "EMAIL")
    @Email(message = "Endereço de e-mail informado está invalido")
    private String email;

    @Column(name = "TELEFONE_CELULAR")
    @NotBlank(message = "O campo telefone não pode estar em branco")
    private String telefoneCelular;

    @Column(name = "TIPO_PESSOA")
    private String tipoPessoa;

    @Column(name = "CPF_CNPJ")
    @NotBlank(message = "O campo cpfCnpj não pode estar em branco")
    private String cpfCnpj;

    @Column(name = "NIVEL_ACESSO")
    private String nivelAcesso;

    @Column(name = "DATA_INCLUSAO")
    @NotBlank(message = "O campo dataInclusao não pode estar em branco")
    public LocalDateTime dataInclusao;

    @Column(name = "DATA_ALTERACAO")
    public LocalDateTime dataAlteracao;

}
