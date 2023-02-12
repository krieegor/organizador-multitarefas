package br.com.organizador.tarefas.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

@Table(name = "TB_LOGIN")
public class TbLogin {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_login;
    @ManyToOne // essa notacao significa que muitos logins estarao associados a um mesmo e unico usuario
    @Column(name = "USUARIO_ID")
    public TbUsuarios usuario_id;

    @Column(name = "DATA_INCLUSAO_LOGIN")
    @NotBlank(message = "O campo dataInclusaoLogin não pode estar em branco")
    @NotEmpty(message = "O campo dataInclusaoLogin não pode ser vazio")
    @NotNull(message = "O campo dataInclusaoLogin não pode ser nulo")
    public LocalDateTime dataInclusaoLogin;

    @Column(name = "DATA_ALTERACAO")
    public LocalDateTime dataAlteracao;
}
