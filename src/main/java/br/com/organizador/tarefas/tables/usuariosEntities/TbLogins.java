package br.com.organizador.tarefas.tables.usuariosEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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

@Table(name = "TB_LOGIN")
public class TbLogins {

    @Id
    @Column(name = "LOGIN_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginId;
    @ManyToOne // essa notacao indica que muitos logins estarao associados a uma pessoa
    @JoinColumn(name = "PESSOA_ID")
    public TbPessoas pessoaId;

    @Column(name = "DATA_INCLUSAO_LOGIN")
    @NotBlank(message = "O campo dataInclusaoLogin não pode estar em branco")
    public LocalDateTime dataInclusaoLogin;

    @Column(name = "DATA_ALTERACAO_LOGIN")
    @NotBlank(message = "O campo dataInclusaoLogin não pode estar em branco")
    public LocalDateTime dataAlteracaoLogin;

    @Column(name = "DATA_INCLUSAO_SENHA")
    @NotBlank(message = "O campo dataInclusaoLogin não pode estar em branco")
    public LocalDateTime dataInclusaoSenha;
    @Column(name = "DATA_ALTERACAO_SENHA")
    @NotBlank(message = "O campo dataInclusaoLogin não pode estar em branco")
    public LocalDateTime dataAlteracaoSenha;

    @Column(name = "NIVEL_ACESSO")
    @NotBlank(message = "O campo nivelAcesso não pode estar em branco")
    private Long nivelAcesso;

    @Column(name = "LOGIN_BLOQUEADO")
    @NotNull(message = "O campo nivelAcesso não pode estar em branco")
    private Boolean loginBloqueado;

    @Column(name = "LOGIN_VERIFICADO")
    private Boolean loginVerificado;
}
