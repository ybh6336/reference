
macos:

lsof -i -P | grep LISTEN | grep :$PORT

nc -vz localhost 9092

------------------------------------------------------------------------------------------

git:

git branch --unset-upstream

git reset HEAD~1

git commit --amend

git submodules:
https://www.educative.io/answers/how-to-specify-a-branch-tag-when-adding-a-git-submodule
git submodule add -b <branch> https://bitbucketdc-cluster03.jpmchase.net/scm/safepayfndsvcs/safepay-schema-registry.git safepay-schema-registry

git submodule update --remote

So here are my findings so far.

Since a git submodule is merely tracking another remote repository, we could control what commit our submodule points to.

1) We can push new commits to the submodule (in this case, safepay-schema-registry), but in order to make the parent (in this case, funding-service) aware of the new commits, we would need to issue the command `git submodule update --remote` (which is what the maven profile `pull-schema` does for us).

So technically, even after breaking changes to safepay-schema-registry were pushed, funding-service could have been made completely unaware of the changes, by telling folks NOT to issue `-P pull-schema`.

2) What if I do issue the command accidentally and my build breaks, you ask?
    2.1) cd <funding_service root>
    2.2) cd safepay-schema-registry
    2.3) git checkout <commit_hash>
            where `commit_hash` is the git commit hash of the working version of swagger. You could just use the commit previous to the one that broke the build.

3) As pointed out in #1 above, one could commit new changes to safepay-schema-registry, without impacting funding-service (no `-P pull-schema`, and if one does, use #2). When the changes are ready to be consumed by funding-service:
    3.1) Issue `mvn clean install -P pull-schema` in funding-service.
    3.2) Fix build in local.
    3.3) Remember to do a `git add ...` for `safepay-schema-registry` changes too.




Local repository as submodule:
```
git config --global protocol.file.allow always

git submodule add -b feature/SAFEPAY-16552-cfs-swagger /Users/R743988/jpmc/ccb/safepay-schema-registry local-safepay-schema-registry
```
https://git-scm.com/docs/git-config#Documentation/git-config.txt-protocolltnamegtallow
https://github.com/flatpak/flatpak-builder/issues/495#issuecomment-1297480817
https://github.blog/open-source/git/git-security-vulnerabilities-announced/#cve-2022-39253


Remove and re-add:
git rm safepay-schema-registry
git submodule add -b develop/2025.02 https://bitbucketdc-cluster03.jpmchase.net/scm/safepayfndsvcs/safepay-schema-registry.git safepay-schema-registry

git submodule add -b develop/2025.03 https://bitbucketdc-cluster03.jpmchase.net/scm/safepaypcisvcs/commerce-wallet-schema-registry.git commerce-wallet-schema-registry


tags:
```
git tag
git checkout tags/3.2.2 -b 3.2.2
```

Show only file names in a commit:
```
git diff-tree --no-commit-id --name-only fe43538b1d2b7eacab4a64194a9acc4b2623d4e4 -r
git show --pretty="" --name-only fe43538b1d2b7eacab4a64194a9acc4b2623d4e4
```



------------------------------------------------------------------------------------------

chrome:

```
Access to fetch at '[https://funding-dda-service-dev2.dev.aws.jpmchase.net/jpmc/payments/payment-instructions/funding-dda/v1/transactions'](https://funding-dda-service-dev2.dev.aws.jpmchase.net/jpmc/payments/payment-instructions/funding-dda/v1/transactions%27 "https://funding-dda-service-dev2.dev.aws.jpmchase.net/jpmc/payments/payment-instructions/funding-dda/v1/transactions%27") from origin 'http://localhost:8081' has been blocked by CORS policy
```

open -a Google\ Chrome --args --disable-web-security --user-data-dir="tmp"

------------------------------------------------------------------------------------------

vi

cheatsheet - https://web.archive.org/web/20161221161539/http://bullium.com/support/vim.html

------------------------------------------------------------------------------------------

docker

prune:
https://docs.docker.com/config/pruning/
```
docker container prune
docker image prune -a
docker volume prune
docker network prune
```

------------------------------------------------------------------------------------------

maven

```
mvn clean org.jacoco:jacoco-maven-plugin:0.8.8:prepare-agent verify org.jacoco:jacoco-maven-plugin:0.8.8:report
```

sonar
```
mvn clean verify sonar:sonar
```

`mvn help:effective-pom -Dverbose`

------------------------------------------------------------------------------------------

git log --pretty=oneline --abbrev-commit 327d676471da84efb7e804c521c9863849abd780..HEAD

git revert --no-commit 327d676471da84efb7e804c521c9863849abd780..HEAD -m 1

^^^ Squash after 'revert' in order to have a single commit.

https://gist.github.com/rponte/8a7c95232f469a4b6fd17dfedb8b90b4


------------------------------------------------------------------------------------------

git log --pretty=oneline --abbrev-commit 10499caa2df0543114740c5d54572f35e7f05f65..HEAD

git revert --no-commit 10499caa2df0543114740c5d54572f35e7f05f65..HEAD -m 1

------------------------------------------------------------------------------------------

find / -name 'tfenv' 2>/dev/null

find . -name '*.java' ! -name '*Test.java' | xargs grep -si 'event-recon'

------------------------------------------------------------------------------------------

git show --name-only 832f288e1ca3efccff8325f8e0ecdf6f9d3e6f87

------------------------------------------------------------------------------------------






