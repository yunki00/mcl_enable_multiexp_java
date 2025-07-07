%module Mcl

%include "std_string.i"
%include "std_except.i"
%include "std_vector.i"

// %apply(char *STRING, size_t LENGTH) { (const char *cbuf, size_t bufSize) };

%typemap(jni) (const char *cbuf, size_t bufSize) "jbyteArray";
%typemap(jtype) (const char *cbuf, size_t bufSize) "byte[]";
%typemap(jstype) (const char *cbuf, size_t bufSize) "byte[]";

%typemap(in) (const char *cbuf, size_t bufSize) {
    $1 = (char *) JCALL2(GetByteArrayElements, jenv, $input, NULL); // (const char *) -> (char *) 로 수정
    $2 = (size_t) JCALL1(GetArrayLength, jenv, $input);
}
%typemap(freearg) (const char *cbuf, size_t bufSize) {
    JCALL3(ReleaseByteArrayElements, jenv, $input, (jbyte *)$1, JNI_ABORT);
}

%{
#include <mcl/bls12_381.hpp>

#include "mcl_impl.hpp"

%}

%typemap(jtype) void serialize "byte[]"
%typemap(jstype) void serialize "byte[]"
%typemap(jni) void serialize "jbyteArray"
%typemap(javaout) void serialize { return $jnicall; }
%typemap(in, numinputs=0) std::string& out (std::string buf) "$1=&buf;"
%typemap(argout) std::string& out {
  $result = JCALL1(NewByteArray, jenv, $1->size());
  JCALL4(SetByteArrayRegion, jenv, $result, 0, $1->size(), (const jbyte*)$1->c_str());
}

%template(G1Vector) std::vector<G1>;
%template(G2Vector) std::vector<G2>;
%template(GTVector) std::vector<GT>;
%template(FrVector) std::vector<Fr>;

%include "mcl_impl.hpp"

%javaconst(1);
#define BN254 0
#define BLS12_381 5
#define SECP256K1 102

