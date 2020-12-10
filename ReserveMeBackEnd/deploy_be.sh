ssh -o "StrictHostKeyChecking no" -t -i reserveme_key_be.ppk reserve-me@91.227.139.202 sh stop_service.sh
scp -o "StrictHostKeyChecking no" -i reserveme_key_be.ppk ./build/libs/demo-0.0.1-SNAPSHOT.jar reserve-me@91.227.139.202:/home/reserve-me
ssh -o "StrictHostKeyChecking no" -t -i reserveme_key_be.ppk reserve-me@91.227.139.202 sh start_service.sh
