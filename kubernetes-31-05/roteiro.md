# Lista de comandos usados durante a aula

## A lista a seguir foi apresentada em aula, mas pode ter alguma pequena diferença na ordem em relação à gravação do vídeo, pois estou montando a lista antes de a gravação estar disponível.

---

`kubectl version`
 
Usado para verificar a versão do Kubernetes instalado e ao mesmo tempo valida se a instalação está ok.

--

`kubectl create deployment nginx-depl --image=nginx`

Criamos um novo deployment chamado *nginx-depl* a partir da imagem _nginx_

--

`kubectl get deployment` 

`kubectl get replicaset`

`kubectl get pod`

Para verificar quais recursos estão disponíveis, usamos o get

--

`kubectl edit deployment nginx-depl`

Um arquivo foi gerado a partir da inscrição create anterior. Aqui podemos analisar alguns itens presentes por padrão no arquivo

--

`kubectl delete pod [coloque aqui o nome do POD]`

`kubectl get pod`

Remove um pod. Observe que depois de removido, um novo é automaticamente criado.
--

`kubectl logs [coloque aqui o nome do POD]`

Apresenta o log do container executando no Pod

--

`kubectl describe pod [coloque aqui o nome do POD]`

Apresenta detalhes da construção do Pod

--

`kubectl delete deployment [coloque aqui o nome do deployment]`

Para remover um deployment

--

`kubectl apply -f nginx-deployment.yml`

Cria um deployment a partir de um arquivo *yml*.

A ordem de construção, deve ser de acordo com a necessidade do recurso. Por exemplo, antes de executar para o banco de dados, a configuração necessária deve ser feita.

No exemplo uma possível ordem é:
> mongo-config.yml

> mongo-secret.yml

> mongo.yml

> mongo-express.yml

> mongo-express-service.yml

--

`kubectl get service`

Além dos recursos já vistos temos agora também os serviços

--

`kubectl describe service [nome do serviço]`

`kubectl get pod -o wide`

Observe que o IP do Pod é usado dentro do serviço

--

`kubectl get all | grep mongo`

Para listar todos os recursos criados que contenham o nome *mongo*.