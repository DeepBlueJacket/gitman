#!/bin/bash
# Compila todo en  /src
# Copia *.class y los ./assets en ./build
# Nota: llamar desde la raiz del juego
javac -classpath jna.jar:. src/*
rm -r build/*
mkdir build/assets
mv src/*.class build
cp -r ./assets/* ./build/assets

