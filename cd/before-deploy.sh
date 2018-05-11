#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    openssl aes-256-cbc -K $encrypted_eedb18d92bf8_key -iv $encrypted_eedb18d92bf8_iv -in cd/codesigning.asc.enc -out cd/codesigning.asc -d
    gpg --fast-import cd/codesigning.asc
fi

if [[ "${TRAVIS_TAG}" != "" ]]; then
    openssl aes-256-cbc -K $encrypted_eedb18d92bf8_key -iv $encrypted_eedb18d92bf8_iv -in cd/codesigning.asc.enc -out cd/codesigning.asc -d
    gpg --fast-import cd/codesigning.asc
fi