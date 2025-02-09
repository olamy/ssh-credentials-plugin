/*
 * The MIT License
 *
 * Copyright (c) 2011-2012, CloudBees, Inc., Stephen Connolly.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.cloudbees.jenkins.plugins.sshcredentials;

import edu.umd.cs.findbugs.annotations.CheckForNull;
import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.util.Secret;

import java.util.List;

/**
 * Details of a SSH user with a private key.
 */
public interface SSHUserPrivateKey extends SSHUser {
    /**
     * Returns the first private key. This should be in OpenSSH format.
     *
     * @return This is the actual content of the first private key and not the path to the private key.
     * @deprecated use {@link #getPrivateKeys()}
     */
    @Deprecated
    @NonNull
    default String getPrivateKey() {
        List<String> keys = getPrivateKeys();
        return keys.isEmpty() ? "" : keys.get(0);
    }

    /**
     * Gets the passphrase for the private keys or {@code null} if the private keys are not protected by a
     * passphase.
     *
     * @return the passphrase for the private keys or {@code null} if the private key are not protected by
     *         a passphase.
     */
    @CheckForNull
    Secret getPassphrase();

    /**
     * Returns a collection of keys to try in order for authentication.
     *
     * @return a collection of keys to try in order for authentication.
     * @since 0.5
     * @see SSHAuthenticator#getPrivateKeys
     */
    @NonNull
    List<String> getPrivateKeys();

}
