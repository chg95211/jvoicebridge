echo "Make Header..."
javah -classpath ../../build/lib/softphone.jar com.sun.mc.softphone.media.alsa.AudioDriverAlsa
echo "Compile..."
gcc -c -fPIC -O AudioDriverAlsa.c Setup.c GetAudioDevices.c
echo "Link..."
gcc -shared -W1,-soname,libMediaFrameworkAmd64.so -o libMediaFrameworkAmd64.so AudioDriverAlsa.o Setup.o GetAudioDevices.o -lasound
