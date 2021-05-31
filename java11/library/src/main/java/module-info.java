import com.bdshadow.java11.api.Print;
import com.bdshadow.java11.api.Say;
import com.bdshadow.java11.impl.PrintImpl;
import com.bdshadow.java11.service.SayProvider;

module library {
    exports com.bdshadow.java11.service;
    exports com.bdshadow.java11.api;

    // The service must be a class type, an interface type, or an annotation type.
    // It is a compile-time error if a provides directive specifies an enum type as the service.
    // Must have
    provides Print with PrintImpl;

    provides Say with SayProvider;
}