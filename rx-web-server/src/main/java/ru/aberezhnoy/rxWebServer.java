package ru.aberezhnoy;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Deque;
import java.util.LinkedList;

public class rxWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8088);

        Observable.<Socket>create(new ObservableOnSubscribe<Socket>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Socket> emitter) throws Exception {
                        try {
                            Socket socket = serverSocket.accept();
                            System.out.println("New connection");
                            emitter.onNext(socket);
                        } catch (Exception ex) {
                            emitter.onError(ex);
                        }
                    }
                })
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())
                .map(new Function<Socket, Deque<String>>() {
                    @Override
                    public Deque<String> apply(@NonNull Socket socket) throws Exception {
                        BufferedReader input = new BufferedReader(
                                new InputStreamReader(
                                        socket.getInputStream(), StandardCharsets.UTF_8));
                        while (!input.ready()) ;

                        Deque<String> request = new LinkedList<>();
                        while (input.ready()) {
                            String line = input.readLine();
                            System.out.println(line);
                            request.add(line);
                        }
                        return request;
                    }
                }).subscribe(
                        request -> request.forEach(System.out::println),
                        err -> System.out.println(err.getMessage())
                );
        System.out.println("Press any key");
        System.in.read();
    }
}
