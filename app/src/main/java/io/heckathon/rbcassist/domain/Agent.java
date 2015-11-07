package io.heckathon.rbcassist.domain;

public class Agent extends Person {

	private String agentId;

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Agent agent = (Agent) o;

		return !(getAgentId() != null ? !getAgentId().equals(agent.getAgentId()) : agent.getAgentId() != null);

	}

	@Override
	public int hashCode() {
		return getAgentId() != null ? getAgentId().hashCode() : 0;
	}
}
