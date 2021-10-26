package br.com.carv.registrations.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateId;

    @Column(length = 2, nullable = false)
    private String stateInitials;

    @Column(length = 50, nullable = false)
    private String stateName;

    public State() {

    }

    public State(Long stateId, String stateInitials, String stateName) {
        this.stateId = stateId;
        this.stateInitials = stateInitials;
        this.stateName = stateName;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getStateInitials() {
        return stateInitials;
    }

    public void setStateInitials(String stateInitials) {
        this.stateInitials = stateInitials;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return "Id: " + getStateId() + " Initials State: " + getStateInitials() + " State Name: " + getStateName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(stateId, state.stateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stateId);
    }
}
