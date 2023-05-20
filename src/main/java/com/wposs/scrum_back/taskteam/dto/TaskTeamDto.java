package com.wposs.scrum_back.taskteam.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskTeamDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID taskTeamId;

    @NotBlank(message = "El nombre de la tarea no debe ser null")
    @Pattern(regexp = "^[a-zA-Z ]+$",message = "El nombre de la tarea solo debe contener letras")
    @Size(max = 100,message = "El nombre de la tarea no debe sobre pasar los 100 caracteres")
    private String taskName;
    @JsonProperty(value = "teamId")
    private UUID teamId;
    @JsonProperty(value = "teamName",access = JsonProperty.Access.READ_ONLY)
    private String teamName;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    public UUID getTaskTeamId() {
        return taskTeamId;
    }

    public void setTaskTeamId(UUID taskTeamId) {
        this.taskTeamId = taskTeamId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
