package com.tms.common.adaptor;

/**
 * Created by hp on 10/28/2017.
 */
public abstract class BasicAdaptor <M, D> {

    public abstract M toModel(D dto);

    public abstract D toDTO(M Model);
}


