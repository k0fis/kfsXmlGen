package kfs.kfsUtils.kfsXmlGen;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Collection;

/**
 * kfs class for String builder with short names
 * @author pavedrim
 */
public class kfsSb extends OutputStream {

    public static final String nl = "\n";
    private StringBuilder sb;
    private String linePrefix;
    private String linePostfix;
    private String space = "";

    public kfsSb() {
        this("");
    }

    public kfsSb(String space) {
        sb = new StringBuilder();
        linePrefix = "";
        linePostfix = "";
        this.space = (space != null) ? space : "";
    }

    public kfsSb aSb(kfsSb ksb) {
        sb.append(ksb.sb);
        return this;
    }

    public boolean isEmpty() {
        return sb.length() <= 0;
    }

    public kfsSb aTimes(int times, String... objs) {
        for (int i = 0; i < times; i++) {
            for (Object o : objs) {
                sb.append(o).append(space);
            }
        }
        return this;
    }

    public kfsSb aTimes(int times, String txt, String sep) {
        for (int i = 0; i < times; i++) {
            if (i > 0) {
                sb.append(sep);
            }
            sb.append(txt);
        }
        return this;
    }

    /**
     * append plus new line and the end
     * @param objs
     * @return
     */
    public kfsSb anl(Object... objs) {
        return a(objs).nl();
    }

    public kfsSb anum(int num, int leadZeroCount) {
        return a(String.format("%1$0" + leadZeroCount + "d", num));
    }

    /**
     * append
     * @param objs
     * @return
     */
    public kfsSb a(Object... objs) {
        for (Object o : objs) {
            sb.append(o == null ? "" : o).append(space);
        }
        return this;
    }

    public kfsSb ad(boolean append, Object... objs) {
        if (append) {
            return a(objs);
        }
        return this;
    }

    public kfsSb af(String format, Object... objs) {
        return a(String.format(format, objs));
    }

    /**
     * append new line only
     * @return
     */
    public kfsSb nl() {
        return nl(true);
    }

    public kfsSb nl(boolean append) {
        if (append) {
            sb.append(linePostfix).append(nl).append(linePrefix);
        }
        return this;
    }

    
    public kfsSb aex(Exception ex) {
        PrintStream ps = new PrintStream(this);
        ex.printStackTrace(ps);
        return nl(true);
    }

    public <T> kfsSb aIter(Iterable<T> i, kfsConvertor<T, String> c, String space) {
        boolean f = true;
        for (T l : i) {
            if (f) {
                f = false;
            } else {
                a(space);
            }
            a(c.convert(l));
        }
        return this;
    }

    public <T> kfsSb adIter2Nl(boolean append, String prefix, //
            String postfix, Iterable<T> i) {
        if (!append) {
            return this;
        }
        for (T l : i) {
            a(prefix).a(l).anl(postfix);
        }
        return this;
    }

    public <T> kfsSb aIterF(String format, String space, Iterable<T> i) { //
        boolean f = true;
        for (T l : i) {
            if (f) {
                f = false;
            } else {
                a(space);
            }
            a(String.format(format, l));
        }
        return this;
    }

    public <T> kfsSb adIter(boolean append, String prefix, String space, //
            String postfix, Iterable<T> i) {
        if (append) {
            a(prefix).aIter(i, space).a(postfix);
        }
        return this;
    }

    public <T> kfsSb aIterNl(Iterable<T> i) {
        for (T l : i) {
            anl(l);
        }
        return this;
    }

    public <T> kfsSb aIterE(Iterable<T> i, Collection<T> except, String space) {
        boolean f = true;
        for (T l : i) {
            if (except.contains(l)) {
                continue;
            }
            if (f) {
                f = false;
            } else {
                a(space);
            }
            a(l);
        }
        return this;
    }

    public <T> kfsSb aIter(Iterable<T> i, String space) {
        boolean f = true;
        for (T l : i) {
            if (f) {
                f = false;
            } else {
                a(space);
            }
            a(l);
        }
        return this;
    }

    public <T> kfsSb aIter(T[] i, String space) {
        boolean f = true;
        for (T l : i) {
            if (f) {
                f = false;
            } else {
                a(space);
            }
            a(l);
        }
        return this;
    }

    /**
     *
     * @return created string
     */
    @Override
    public String toString() {
        return sb.toString();
    }

    /**
     * @return the linePrefix
     */
    public String getLinePrefix() {
        return linePrefix;
    }

    /**
     * @param linePrefix the linePrefix to set
     * @return itself - for concatenate method calling
     */
    public kfsSb setLinePrefix(String linePrefix) {
        this.linePrefix = linePrefix;
        return this;
    }

    /**
     * @return the linePostfix
     */
    public String getLinePostfix() {
        return linePostfix;
    }

    /**
     * @param linePostfix the linePostfix to set
     * @return itself - for concatenate method calling
     */
    public kfsSb setLinePostfix(String linePostfix) {
        this.linePostfix = linePostfix;
        return this;
    }

    /**
     * add object with first string is notnull and length is more than 0
     * @param testStr - testing string
     * @param txts - appendable objects
     * @return itself - for concatenate method calling
     */
    public kfsSb as(String testStr, Object... txts) {
        return ad((testStr != null) && (testStr.length() > 0), txts);
    }

    @Override
    public void write(int b)  {
        sb.append( (char)b);
    }
}
