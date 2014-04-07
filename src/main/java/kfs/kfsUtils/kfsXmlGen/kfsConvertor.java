package kfs.kfsUtils.kfsXmlGen;

/**
 * Simple interface for declare convert metohd from source type (first generics)
 * into destination (second generics) type.
 * 
 * @author pavedrim
 */
public interface kfsConvertor<Tfrom, Tto> {

    Tto convert(Tfrom object);
}
