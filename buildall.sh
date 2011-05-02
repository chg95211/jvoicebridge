read -p "Start Buildprocess"

#read -p "Delete dist folder"
rm -r dist/

#read -p "Delete tmp folder"
rm -r tmp/

#read -p "Build Stun"
cd stun/
ant

#read -p "Build Common"
cd ../common/
ant

#read -p "Build Softphone"
cd ../softphone/
ant

#read -p "Build Bridgemonitor"
cd ../bridgemonitor/
ant

#read -p "Build Voip"
cd ../voip/
ant

#read -p "Build Voicelib"
cd ../voicelib/
ant

#read -p "Build Whole Project"
cd ..
ant dist
