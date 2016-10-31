package com.telenav.playground.commander.permission.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import com.telenav.playground.commander.permission.SocialAccount;
import com.telenav.playground.commander.permission.SocialAccountType;

/**
 * Immutable implementation of {@link SocialAccount}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableSocialAccount.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "SocialAccount"})
public final class ImmutableSocialAccount implements SocialAccount {
    private final SocialAccountType type;
    private final String username;

    private ImmutableSocialAccount(SocialAccountType type, String username) {
        this.type = type;
        this.username = username;
    }

    /**
     * @return The value of the {@code type} attribute
     */
    @Override
    public SocialAccountType type() {
        return type;
    }

    /**
     * @return The value of the {@code username} attribute
     */
    @Override
    public String username() {
        return username;
    }

    /**
     * Copy the current immutable object by setting a value for the {@link SocialAccount#type() type} attribute.
     * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
     * @param value A new value for type
     * @return A modified copy of the {@code this} object
     */
    public final ImmutableSocialAccount withType(SocialAccountType value) {
        if (this.type == value) {
            return this;
        }
        SocialAccountType newValue = Objects.requireNonNull(value, "type");
        return new ImmutableSocialAccount(newValue, this.username);
    }

    /**
     * Copy the current immutable object by setting a value for the {@link SocialAccount#username() username} attribute.
     * An equals check used to prevent copying of the same value by returning {@code this}.
     * @param value A new value for username
     * @return A modified copy of the {@code this} object
     */
    public final ImmutableSocialAccount withUsername(String value) {
        if (this.username.equals(value)) {
            return this;
        }
        String newValue = Objects.requireNonNull(value, "username");
        return new ImmutableSocialAccount(this.type, newValue);
    }

    /**
     * This instance is equal to all instances of {@code ImmutableSocialAccount} that have equal attribute values.
     * @return {@code true} if {@code this} is equal to {@code another} instance
     */
    @Override
    public boolean equals(Object another) {
        if (this == another) {
            return true;
        }
        return another instanceof ImmutableSocialAccount
                && equalTo((ImmutableSocialAccount) another);
    }

    private boolean equalTo(ImmutableSocialAccount another) {
        return type.equals(another.type)
                && username.equals(another.username);
    }

    /**
     * Computes a hash code from attributes: {@code type}, {@code username}.
     * @return hashCode value
     */
    @Override
    public int hashCode() {
        int h = 31;
        h = h * 17 + type.hashCode();
        h = h * 17 + username.hashCode();
        return h;
    }

    /**
     * Prints the immutable value {@code SocialAccount} with attribute values.
     * @return A string representation of the value
     */
    @Override
    public String toString() {
        return "SocialAccount{"
                + "type=" + type
                + ", username=" + username
                + "}";
    }

    /**
     * Creates an immutable copy of a {@link SocialAccount} value.
     * Uses accessors to get values to initialize the new immutable instance.
     * If an instance is already immutable, it is returned as is.
     * @param instance The instance to copy
     * @return A copied immutable SocialAccount instance
     */
    public static ImmutableSocialAccount copyOf(SocialAccount instance) {
        if (instance instanceof ImmutableSocialAccount) {
            return (ImmutableSocialAccount) instance;
        }
        return ImmutableSocialAccount.builder()
                .from(instance)
                .build();
    }

    /**
     * Creates a builder for {@link ImmutableSocialAccount ImmutableSocialAccount}.
     * @return A new ImmutableSocialAccount builder
     */
    public static ImmutableSocialAccount.Builder builder() {
        return new ImmutableSocialAccount.Builder();
    }

    /**
     * Builds instances of type {@link ImmutableSocialAccount ImmutableSocialAccount}.
     * Initialize attributes and then invoke the {@link #build()} method to create an
     * immutable instance.
     * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
     * but instead used immediately to create instances.</em>
     */
    public static final class Builder {
        private static final long INIT_BIT_TYPE = 0x1L;
        private static final long INIT_BIT_USERNAME = 0x2L;
        private long initBits = 0x3L;

        private SocialAccountType type;
        private String username;

        private Builder() {
        }

        /**
         * Fill a builder with attribute values from the provided {@code SocialAccount} instance.
         * Regular attribute values will be replaced with those from the given instance.
         * Absent optional values will not replace present values.
         * @param instance The instance from which to copy values
         * @return {@code this} builder for use in a chained invocation
         */
        public final Builder from(SocialAccount instance) {
            Objects.requireNonNull(instance, "instance");
            type(instance.type());
            username(instance.username());
            return this;
        }

        /**
         * Initializes the value for the {@link SocialAccount#type() type} attribute.
         * @param type The value for type
         * @return {@code this} builder for use in a chained invocation
         */
        public final Builder type(SocialAccountType type) {
            this.type = Objects.requireNonNull(type, "type");
            initBits &= ~INIT_BIT_TYPE;
            return this;
        }

        /**
         * Initializes the value for the {@link SocialAccount#username() username} attribute.
         * @param username The value for username
         * @return {@code this} builder for use in a chained invocation
         */
        public final Builder username(String username) {
            this.username = Objects.requireNonNull(username, "username");
            initBits &= ~INIT_BIT_USERNAME;
            return this;
        }

        /**
         * Builds a new {@link ImmutableSocialAccount ImmutableSocialAccount}.
         * @return An immutable instance of SocialAccount
         * @throws java.lang.IllegalStateException if any required attributes are missing
         */
        public ImmutableSocialAccount build() {
            if (initBits != 0) {
                throw new IllegalStateException(formatRequiredAttributesMessage());
            }
            return new ImmutableSocialAccount(type, username);
        }

        private String formatRequiredAttributesMessage() {
            List<String> attributes = new ArrayList<String>();
            if ((initBits & INIT_BIT_TYPE) != 0) {
                attributes.add("type");
            }
            if ((initBits & INIT_BIT_USERNAME) != 0) {
                attributes.add("username");
            }
            return "Cannot build SocialAccount, some of required attributes are not set " + attributes;
        }
    }
}
