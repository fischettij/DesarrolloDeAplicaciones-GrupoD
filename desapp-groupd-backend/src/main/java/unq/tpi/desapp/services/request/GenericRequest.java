package unq.tpi.desapp.services.request;

public class GenericRequest<T> {

	public Long requestedBy;
	public T requestObject;
	
	public Long getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(Long requestedBy) {
		this.requestedBy = requestedBy;
	}
	public T getRequestObject() {
		return requestObject;
	}
	public void setRequestObject(T requestObject) {
		this.requestObject = requestObject;
	}
}
