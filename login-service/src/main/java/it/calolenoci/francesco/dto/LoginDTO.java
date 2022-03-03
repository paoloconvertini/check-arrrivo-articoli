package it.calolenoci.francesco.dto;

import java.util.Objects;

public class LoginDTO {
    private String msg;
    private Boolean error;

    public LoginDTO() {
    }

    public LoginDTO(String msg, Boolean error) {
        this.msg = msg;
        this.error = error;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "msg='" + msg + '\'' +
                ", error=" + error +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginDTO loginDTO = (LoginDTO) o;
        return Objects.equals(msg, loginDTO.msg) && Objects.equals(error, loginDTO.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msg, error);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }
}
