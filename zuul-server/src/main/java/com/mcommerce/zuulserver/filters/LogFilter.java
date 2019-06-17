package com.mcommerce.zuulserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LogFilter extends ZuulFilter {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() { //quand?
        return "pre"; // sens du filtre de client -> zull
        // sinon a l'inverse c'est "post"
    }

    @Override
    public int filterOrder() {// defini l'ordre d'execution du filtre ( si on a plusieur filtre)
        return 1;
    }

    @Override
    public boolean shouldFilter() {// le filtre doit s'executer ou pas?
        return true;
    }

    @Override
    public Object run() throws ZuulException {// que'est ce qu'on fait a la requete
        // nous on fait juste un message comme quoi on a intercepter la requête

        HttpServletRequest req = RequestContext.getCurrentContext().getRequest();

        log.info("***** requête interceptée" + req.getRequestURL());

        return null;
    }
}
